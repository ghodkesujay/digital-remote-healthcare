package edu.neu.csye6200.oodfinalproject.model.workqueue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LabResultWorkRequest extends WorkRequest {
    private String labResults;
//    private LabResultWorkRequest prev = new ArrayList<>();
    private LabTestWorkRequest labTestWorkRequest;

    public LabResultWorkRequest() {
        this.setType(Type.LAB_RESULT_REQUEST);
    }
}
