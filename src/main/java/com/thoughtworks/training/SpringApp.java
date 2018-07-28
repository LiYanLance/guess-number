package com.thoughtworks.training;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SpringApp {

    public static void main(String[] args) throws IOException {
        NumberProcessor processor = new NumberProcessor(new ArrayList<Processor>() {{
            add(new OddFilter());
            add(new PlusProcessor(2));
        }});


        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in));
        String line;
        while ((line = in.readLine()).length() != 0) {
            System.out.println(processor.process(line));
        }
    }
}
