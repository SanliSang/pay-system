package com.sanli.pay.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;

/**
 * 自定义注释生成器（利用MBG代码生成器，生成Swagger注解，减轻注释文档开发的工作量；生成model类及其属性的注释）
 */
public class CommentGenerator extends DefaultCommentGenerator {
    private boolean addRemarkComments = false; // 是否添加数据库字段的注释
    //    private boolean suppressAllComments = false; // 是否阻止自动生成的注释
    private static final String EXAMPLE_SUFFIX="Example"; // 后缀Example标识
    private static final String MAPPER_SUFFIX="Mapper"; // 后缀Mapper标识
    private static final String API_MODEL_PROPERTY_FULL_CLASS_NAME="io.swagger.annotations.ApiModelProperty";

    /**
     * 设置用户配置的参数
     */
    @Override
    public void addConfigurationProperties(Properties properties) { // 也就是generatorConfig.xml配置文件
        super.addConfigurationProperties(properties);
        this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
//        this.suppressAllComments = StringUtility.isTrue(properties.getProperty("suppressAllComments"));
    }

    /**
     * 给model的字段添加@ApiModelProperty注释（如果没有就无需加注释）
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        String remarks = introspectedColumn.getRemarks(); // 获取数据库表字段的注释
        //根据参数和备注信息判断是否添加swagger注解信息
        if(addRemarkComments&&StringUtility.stringHasValue(remarks)){
//            addFieldJavaDoc(field, remarks);
            //数据库中特殊字符需要转义（将双引号转成单引号）
            if(remarks.contains("\"")){
                remarks = remarks.replace("\"","'");
            }
            //给model的字段添加swagger注解
            field.addJavaDocLine("@ApiModelProperty(value = \""+remarks+"\")");
        }
    }

    /**
     * 给model的字段添加注释
     */
    private void addFieldJavaDoc(Field field, String remarks) {
        //文档注释开始
        field.addJavaDocLine("/**");
        //获取数据库字段的备注信息
        String[] remarkLines = remarks.split(System.getProperty("line.separator"));
        for(String remarkLine:remarkLines){
            field.addJavaDocLine(" * "+remarkLine);
        }
        addJavadocTag(field, false);
        field.addJavaDocLine(" */");
    }

    /**
     * 给Java文件添加注释以及导入Java类（一般配置注释版权信息、创建日期、作者信息...但这里主要给model添加Swagger注解）
     */
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        super.addJavaFileComment(compilationUnit);
        // 给后缀没有Mapper与Example的Java文件导入io.swagger.annotations.ApiModelProperty注解
        if(!compilationUnit.getType().getFullyQualifiedName().contains(MAPPER_SUFFIX) // Java文件名带有Mapper后缀的
                && !compilationUnit.getType().getFullyQualifiedName().contains(EXAMPLE_SUFFIX)){ // Java文件名带有Example后缀的
            // 给该Java文件导入io.swagger.annotations.ApiModelProperty注解
            compilationUnit.addImportedType(new FullyQualifiedJavaType(API_MODEL_PROPERTY_FULL_CLASS_NAME));
        }
    }

//    @Override
//    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {
//        // 实体类添加 @Data、@Builder、@NoArgsConstructor、@AllArgsConstructor注解
//        // 这里比较尴尬的是BaseRecordGenerator类没有配置不生成getter、setter方法的入口，所以@Data就不需要了
//        if (innerClass instanceof TopLevelClass) {
//            TopLevelClass topLevelClass = (TopLevelClass) innerClass;
//            // 给Java类导入各种注解类
//            topLevelClass.addImportedType(new FullyQualifiedJavaType("lombok.Data"));
//            topLevelClass.addImportedType(new FullyQualifiedJavaType("lombok.Builder"));
//            topLevelClass.addImportedType(new FullyQualifiedJavaType("lombok.NoArgsConstructor"));
//            topLevelClass.addImportedType(new FullyQualifiedJavaType("lombok.AllArgsConstructor"));
//            // 给Java类添加各种注解
//            topLevelClass.addAnnotation("@Data");
//            topLevelClass.addAnnotation("@Builder");
//            topLevelClass.addAnnotation("@NoArgsConstructor");
//            topLevelClass.addAnnotation("@AllArgsConstructor");
//        }
//    }
//
//    @Override
//    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        if (suppressAllComments || !addRemarkComments) {
//            return;
//        }
//
//        // model实体类注释
//        topLevelClass.addJavaDocLine("/**");
//        topLevelClass.addJavaDocLine(" * [表名：" + introspectedTable.getFullyQualifiedTable() + "]"); // 获取表名
//        topLevelClass.addJavaDocLine(" *");
//        topLevelClass.addJavaDocLine(" * @author sanli");
//        topLevelClass.addJavaDocLine(" * @date " + getDateString());
//        topLevelClass.addJavaDocLine(" */");
//
//        // 添加实体类的注解
//        // 因为MBG没有给普通实体类生成注解，所以这里手动调用一下
//        // BaseRecordGenerator类没有调用addClassAnnotation()
//        addClassAnnotation(topLevelClass, introspectedTable, null);
//    }
}
