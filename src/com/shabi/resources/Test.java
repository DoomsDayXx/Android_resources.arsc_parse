package com.shabi.resources;

import java.io.File;
import java.util.Arrays;



public class Test {



    public static void main(String... agrs) {
        byte[] bytye = Utils.getBytye(new File("resources.arsc"));
        Parser parser = new Parser(bytye);
    }
}
