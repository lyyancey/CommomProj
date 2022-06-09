package com.yancey.mall2.mbg;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Generator
 * @Description TODO Generator mbg Code
 * @Author Yancey
 * @Date 2022/6/2 20:29
 * @Version 1.0
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        // Warning messages generated during MBG execution
        List<String> warnings = new ArrayList<String>();
        // When generated repeatedly, rewrite the existing code.
        boolean overwrite = true;
        // Get the configuration file
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        // Create MBG
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        // Execute MBG Generate Code
        myBatisGenerator.generate(null);
        // Print the warning messages
        for (String warning : warnings) {
            System.out.println(warning);
        }


    }
}
