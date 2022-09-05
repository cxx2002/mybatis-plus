package com.cxx;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author 陈喜喜
 * @date 2022-08-16 16:38
 */

public class FastAutoGeneratorTest {

    public static void main(String[] args) {
        FastAutoGenerator.create(
                        "jdbc:mysql://localhost:3306/mybatis_plus?characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8",
                        "root",
                        "123456")
                .globalConfig(builder -> {
                    builder.author("陈喜喜") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            //.enableSwagger() // 开启 swagger 模式
                            // 指定输出目录
                            //直接右键复制项目根目录的绝对路径
                            .outputDir("C:\\Users\\陈喜喜\\IdeaProjects\\mybatisplus-01\\src\\main\\java");
                })
                .packageConfig(builder -> {
                    builder.parent("com.cxx2") // 设置父包名
                            // 设置mapperXml生成路径
                            //直接右键复制项目mapper文件夹的绝对路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapper, "C:\\Users\\陈喜喜\\IdeaProjects\\mybatisplus-01\\src\\main\\java\\com\\cxx2\\mapper"));
                })
                .strategyConfig(builder -> {
                    // 设置需要生成的表名
                    builder.addInclude("t_product")
                            .addInclude("user")
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板(需要导包)，默认的是Velocity引擎模板
                .execute();
    }
}