package edu.neu.csye6200.oodfinalproject.ui.labtechnician;

import edu.neu.csye6200.oodfinalproject.model.workqueue.LabTestWorkRequest;
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

    void openRequestForProcessing(LabTestWorkRequest labTestWorkRequest) {
        ProcessLabTestRequest processLabTestRequest = new ProcessLabTestRequest(this, labTestWorkRequest);
        mainPane.setCenter(processLabTestRequest);
    }

    @FXML
    void trackRequests() {
        TrackWorkRequests trackWorkRequests= new TrackWorkRequests(this);
        mainPane.setCenter(trackWorkRequests);
        setTitle("Track Work Requests");
    }
}
