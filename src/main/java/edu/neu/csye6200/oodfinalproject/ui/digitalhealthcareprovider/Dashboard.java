package edu.neu.csye6200.oodfinalproject.ui.digitalhealthcareprovider;

import edu.neu.csye6200.oodfinalproject.model.workqueue.DoctorOpinionRequest;
import edu.neu.csye6200.oodfinalproject.ui.AbstractParentController;
import javafx.fxml.FXML;

public class Dashboard extends AbstractParentController {

    @FXML
    protected void initialize() {
        super.initialize();

        setTitle("Work Area");
        openWorkArea();
    }

    @FXML
    private void openWorkArea() {
        WorkArea dashboardContent = new WorkArea(this);
        mainPane.setCenter(dashboardContent);
    }

    @FXML
    void trackRequests() {
        TrackWorkRequests trackWorkRequests= new TrackWorkRequests(this);
        mainPane.setCenter(trackWorkRequests);
        setTitle("Track Doctor's Opinion Requests");
    }

    void openDoctorsOpinionRequestForProcessing(DoctorOpinionRequest doctorOpinionRequest) {
        ProcessTreatmentRequest processTreatmentRequest = new ProcessTreatmentRequest(this, doctorOpinionRequest);
        mainPane.setCenter(processTreatmentRequest);
    }

}
