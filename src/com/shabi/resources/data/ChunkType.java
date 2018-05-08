package com.shabi.resources.data;

public interface ChunkType {
    int RES_NULL_TYPE = 0x0000;
    int RES_STRING_POOL_TYPE = 0x0001;
    int RES_TABLE_TYPE = 0x0002;
    int RES_XML_TYPE = 0x0003;
    // Chunk types in RES_XML_TYPE
    int RES_XML_FIRST_CHUNK_TYPE = 0x0100;
    int RES_XML_START_NAMESPACE_TYPE = 0x0100;
    int RES_XML_END_NAMESPACE_TYPE = 0x0101;
    int RES_XML_START_ELEMENT_TYPE = 0x0102;
    int RES_XML_END_ELEMENT_TYPE = 0x0103;
    int RES_XML_CDATA_TYPE = 0x0104;
    int RES_XML_LAST_CHUNK_TYPE = 0x017f;
    // This contains a uint32_t array mapping strings in the string
    // pool back to resource identifiers.  It is optional.
    int RES_XML_RESOURCE_MAP_TYPE = 0x0180;
    // Chunk types in RES_TABLE_TYPE
    int RES_TABLE_PACKAGE_TYPE = 0x0200;
    int RES_TABLE_TYPE_TYPE = 0x0201;
    int RES_TABLE_TYPE_SPEC_TYPE = 0x0202;
}
