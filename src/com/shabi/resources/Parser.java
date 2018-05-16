package com.shabi.resources;

import com.shabi.resources.data.GlobalStringChunk;
import com.shabi.resources.data.PackageChunk;
import com.shabi.resources.data.ResChunkHeader;

public class Parser {

    public Parser(byte[] bytes) {
        int offset = 0;
        ResChunkHeader resChunkHeader = new ResChunkHeader(bytes);
        GlobalStringChunk globalStringChunk = new GlobalStringChunk(Utils.copy(bytes, offset += resChunkHeader.mChunkSize, bytes.length - offset));
        PackageChunk packageChunk = new PackageChunk(Utils.copy(bytes, offset += globalStringChunk.mChunkSize, bytes.length - offset));
    }

}
