package application;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controlador2 {
	
	/*
	 * esta clase la utilizo para controlar el login, esta clase solicitará el usuario y la contraseña
	 * de aquí pasaremos a las imagenes. Esta case solo se encarga de pasar las imagenes
	 */
	
	@FXML
	AnchorPane rootPane;// Este es el id de mi rootpane Principal

	
	
	// ahora las siguientes lineas de codigo se encargan de cargar los paneles que
		// voy a utilizar para pasarlo
	@FXML
	private Pane pane1, pane2, pane3, pane4;

	@FXML
	private ImageView drawerImage;

	public void initialize() {
		// este metodo lo utilizo para cargar las imagenes


		pane1.setStyle("-fx-background-image: url('application/urano1.jpg')");
		pane2.setStyle("-fx-background-image: url('application/urano2.jpg')");
		pane3.setStyle("-fx-background-image: url('application/urano3.jpg')");
		pane4.setStyle("-fx-background-image: url('application/urano4.jpg')");

		Animation();

		
	}

	public void Animation() {
		// Este metodo es el encargado de el pase de diapositivas

		// aquí uso el metodo
		// FadeTransition para jugar
		// con la visibilidad de las
		// imagenes y darle opacidad
		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(4), pane4);
		fadeTransition.setFromValue(1);// el parametro 1 es para la opacidad total
		fadeTransition.setToValue(0);// el parametro 0 lo uso para quitar dicha opacidad
		fadeTransition.play();

		fadeTransition.setOnFinished(event -> {
			FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(4), pane3);
			fadeTransition1.setFromValue(1);
			fadeTransition1.setToValue(0);
			fadeTransition1.play();

			fadeTransition1.setOnFinished(event1 -> {

				FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(4), pane2);
				fadeTransition2.setFromValue(1);
				fadeTransition2.setToValue(0);
				fadeTransition2.play();

				fadeTransition2.setOnFinished(event2 -> {

					FadeTransition fadeTransition00 = new FadeTransition(Duration.seconds(4), pane2);
					fadeTransition00.setFromValue(0);
					fadeTransition00.setToValue(1);
					fadeTransition00.play();

					fadeTransition00.setOnFinished(event3 -> {
						FadeTransition fadeTransition11 = new FadeTransition(Duration.seconds(4), pane3);
						fadeTransition11.setFromValue(0);
						fadeTransition11.setToValue(1);
						fadeTransition11.play();

						fadeTransition11.setOnFinished(event4 -> {
							FadeTransition fadeTransition22 = new FadeTransition(Duration.seconds(4), pane4);
							fadeTransition22.setFromValue(0);
							fadeTransition22.setToValue(1);
							fadeTransition22.play();

							fadeTransition22.setOnFinished(event5 -> {
								Animation();
							});
						});

					});
				});

			});

		});
	}
	
	@FXML
	private void closeApp() {
		Stage thisStage = (Stage) rootPane.getScene().getWindow();
	    thisStage.close();	
	}

}
