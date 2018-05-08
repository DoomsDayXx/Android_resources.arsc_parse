package com.shabi.resources;

import com.shabi.resources.data.GlobalStringChunk;
import com.shabi.resources.data.ResChunkHeader;

public class Parser {

    public Parser(byte[] bytes) {
        int offset = 0;
        ResChunkHeader resChunkHeader = new ResChunkHeader(bytes);
        GlobalStringChunk globalStringChunk = new GlobalStringChunk(Utils.copy(bytes, offset += resChunkHeader.mChunkSize, bytes.length - offset));
    }

}
