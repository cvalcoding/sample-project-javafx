module com.cvalcoding.sample_project_javafx {
	requires javafx.graphics;
	requires javafx.controls;
	requires static lombok;
	requires java.sql;

	exports com.cvalcoding.sample_project_javafx;
	exports com.cvalcoding.sample_project_javafx.ui;
}