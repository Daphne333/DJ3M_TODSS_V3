package Controller.Servlets;

import javax.servlet.annotation.WebServlet;

import Model.Service.TrainingService;
import Model.Service.ServiceProvider;

@WebServlet("/TrainingAanmakenServlet")
public class TrainingAanmakenServlet {
	TrainingService trainingService = ServiceProvider.getTraining();
	

}
