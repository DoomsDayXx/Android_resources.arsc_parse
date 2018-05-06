package com.shabi.resources;

import com.shabi.resources.data.ResChunkHeader;

public class Parser {

    public Parser(byte[] bytes) {
        new ResChunkHeader(bytes);
    }

}
