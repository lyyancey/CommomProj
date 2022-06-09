package com.yancey.mall2.mbg;

import com.github.pagehelper.util.StringUtil;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;

/**
 * @ClassName CommentGenerator
 * @Description TODO customer comments generator
 * @Author Yancey
 * @Date 2022/6/2 20:29
 * @Version 1.0
 */
public class CommentGenerator extends DefaultCommentGenerator {
    private boolean addRemarkComments = false;
    private static final String EXAMPLE_SUFFIX = "Example";
    private static final String API_MODEL_PROPERTY_FULL_CLASS_NAME = "io.swagger.annotations.ApiModelProperty";
    /**
     * @Author Yancey
     * @Description //TODO set user-defined properties
     * @Date 14:27 2022/6/3
     * @Param properties 1
     * @return
     **/
    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
        this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
    }

    /**
     * @Author Yancey
     * @Description //TODO add comments for fields
     * @Date 14:27 2022/6/3
     * @Param field
     * @Param introspectedTable
     * @Param introspectedColumn
     * @return
     **/
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        super.addFieldComment(field, introspectedTable, introspectedColumn);
        String remarks = introspectedColumn.getRemarks();
        // Determine whether to add remarks based on parameters and remarks
        if(addRemarkComments && StringUtility.stringHasValue(remarks)) {
            this.addFiledJavaDoc(field, remarks);
            // The specific field of the database need to escape
            if(remarks.contains("\"")){
                remarks = remarks.replace("\"", "'");
            }
            // add swagger annotation  for filed of model
            field.addJavaDocLine("@ApiModelProperty(value = \""+remarks+"\")");
        }

    }

    /**
     * @Author Yancey
     * @Description //TODO add comments for fields of model
     * @Date 14:27 2022/6/3
     * @Param field
     * @Param remarks
     * @Date 14:35 2022/6/3
     * @return void
     **/
    private void addFiledJavaDoc(Field field, String remarks) {
        // the document of field beginning
        field.addJavaDocLine("/**");
        // get the message of database column of comments
        String[] remarkLines = remarks.split(System.getProperty("line.separator"));
        for(String remarkLine : remarkLines) {
            field.addJavaDocLine(" * " + remarkLine);
        }
        addJavadocTag(field, false);
        field.addJavaDocLine(" */");
    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        super.addJavaFileComment(compilationUnit);
        // only add the import of the swagger annotation class in model
        if(!compilationUnit.isJavaInterface() && ! compilationUnit.getType().getFullyQualifiedName().contains(EXAMPLE_SUFFIX)) {
            compilationUnit.addImportedType(new FullyQualifiedJavaType(API_MODEL_PROPERTY_FULL_CLASS_NAME));
        }
    }
}
