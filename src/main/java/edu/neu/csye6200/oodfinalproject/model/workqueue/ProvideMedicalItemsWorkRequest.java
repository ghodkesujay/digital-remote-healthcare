package edu.neu.csye6200.oodfinalproject.model.workqueue;

import edu.neu.csye6200.oodfinalproject.model.medicalstore.MedicalStoreInventoryItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ProvideMedicalItemsWorkRequest extends WorkRequest {
    private String prescription;
    private List<MedicalStoreInventoryItem> medicalStoreInventoryItems;

    public ProvideMedicalItemsWorkRequest() {
        this.setType(Type.PROVIDE_MEDICAL_ITEMS_REQUEST);
    }
}
