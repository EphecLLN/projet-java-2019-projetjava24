module stratego {
	
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	
	requires transitive javafx.graphics;
	requires transitive javafx.base;
	requires org.junit.jupiter.api;
	requires junit;
	
	opens controller to javafx.fxml;
	exports main to javafx.graphics;
}