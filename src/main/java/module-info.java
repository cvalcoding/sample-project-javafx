module com.cvalcoding.sample_project_javafx {
	requires javafx.graphics;
	requires javafx.controls;
	requires static lombok;
	requires java.sql;
	requires org.apache.logging.log4j;
	requires org.apache.logging.log4j.core;

	opens com.cvalcoding.sample_project_javafx.model.entity to javafx.base;

	exports com.cvalcoding.sample_project_javafx;
	exports com.cvalcoding.sample_project_javafx.ui;
	exports com.cvalcoding.sample_project_javafx.model.entity;
}