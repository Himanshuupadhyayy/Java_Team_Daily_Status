package com.blogApp.Payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Setter
@Getter
public class PostResponse {

    private List<PostDto> content;
    private int pagenumber;
    private int pageSize;
    private long totleElement;
    private int totlePages;
    private boolean lastPage;



}
