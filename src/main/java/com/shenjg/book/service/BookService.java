package com.shenjg.book.service;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * BookService
 *
 * @author shenjg
 * @date 2019/07/09
 */
@Service
public class BookService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 搜索文档
     *
     * @param indexName  索引名
     * @param keyword    关键字
     * @param fieldNames 查询字段名
     * @param pageNum    页码
     * @param pageSize   第几页
     * @return 文档列表
     */
    public List<Map<String, Object>> searchDocs(String indexName,
                                                String keyword,
                                                String[] fieldNames,
                                                int pageNum,
                                                int pageSize) {

        MultiMatchQueryBuilder multiMatchQuery = QueryBuilders
                .multiMatchQuery(keyword, fieldNames)
                .operator(Operator.AND);

        HighlightBuilder highlightBuilder = new HighlightBuilder();
        HighlightBuilder.Field highlightTitle =
                new HighlightBuilder.Field("title");
        HighlightBuilder.Field highlightFilecontent = new HighlightBuilder.Field("content");

        highlightBuilder.field(highlightTitle);
        highlightBuilder.field(highlightFilecontent);

        highlightBuilder
                .preTags("<span style=color:red>")
                .postTags("</span>");

        // 搜索构建器
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.highlighter(highlightBuilder);
        searchSourceBuilder.query(multiMatchQuery);
        searchSourceBuilder.from((pageNum - 1) * pageSize);
        searchSourceBuilder.size(pageSize);

        // 构造针对索引的新搜索请求
        SearchRequest searchRequest = new SearchRequest(indexName);
        searchRequest.source(searchSourceBuilder);
        List<Map<String, Object>> resultList = new ArrayList<>();

        try {
            SearchResponse searchResponse = restHighLevelClient
                    .search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
            SearchHit[] searchHits = hits.getHits();
            for (SearchHit hit : searchHits) {

                Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                HighlightField hTitle = highlightFields.get("title");

                if (hTitle != null) {
                    String hTitleText = "";
                    Text[] fragments = hTitle.fragments();
                    for (Text text : fragments) {
                        hTitleText += text;
                    }
                    sourceAsMap.put("title", hTitleText);
                }
                HighlightField hFilecontent = highlightFields.get("filecontent");
                if (hFilecontent != null) {
                    String hFilecontentText = "";
                    Text[] fragments = hFilecontent.fragments();
                    for (Text text : fragments) {
                        hFilecontentText += text;
                    }
                    sourceAsMap.put("filecontent", hFilecontentText);
                }
                resultList.add(sourceAsMap);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return resultList;
    }
}
