package edu.neu.csye6200.oodfinalproject.model.workqueue;

import edu.neu.csye6200.oodfinalproject.model.medicalstore.MedicalStoreInventoryItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ProvideTreatmentWorkRequest extends WorkRequest {
    private String prescription;
    private List<MedicalStoreInventoryItem> medicalStoreInventoryItems;

    public ProvideTreatmentWorkRequest() {
        this.setType(Type.PROVIDE_TREATMENT_REQUEST);
    }
}
