package com.ponlanby.heap.profiler.demo;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author ponlanby
 * @since 2020/6/29
 */
public class NativeMemoryLeakDemo {

    public static void main(String[] args) throws IOException, FontFormatException {
        while (true) {
            test();
        }
    }

    private static void test() throws IOException, FontFormatException {
        Resource resource = new ClassPathResource("font/font.ttf");
        Font rawFont = Font.createFont(Font.TRUETYPE_FONT, resource.getFile());
        Font usedFont = rawFont.deriveFont(Font.PLAIN, 30);

        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.setFont(usedFont);
        g2.drawString("hello world", 16, 35);
    }
}
