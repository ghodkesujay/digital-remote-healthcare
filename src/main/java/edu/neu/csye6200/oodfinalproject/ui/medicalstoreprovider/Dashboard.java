package edu.neu.csye6200.oodfinalproject.ui.medicalstoreprovider;

import edu.neu.csye6200.oodfinalproject.model.workqueue.ProvideMedicalItemsWorkRequest;
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

    void openRequestForProcessing(ProvideMedicalItemsWorkRequest provideMedicalItemsWorkRequest) {
        ProcessMedicalItemsRequest processMedicalItemsRequest = new ProcessMedicalItemsRequest(this, provideMedicalItemsWorkRequest);
        mainPane.setCenter(processMedicalItemsRequest);
    }

    @FXML
    void trackRequests() {
        TrackWorkRequests trackWorkRequests= new TrackWorkRequests(this);
        mainPane.setCenter(trackWorkRequests);
        setTitle("Track Work Requests");
    }
}
