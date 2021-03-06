package edu.neu.csye6200.oodfinalproject.ui.digitalhealthcareprovider;

import edu.neu.csye6200.oodfinalproject.model.workqueue.DoctorOpinionRequest;
import edu.neu.csye6200.oodfinalproject.model.workqueue.LabResultWorkRequest;
import edu.neu.csye6200.oodfinalproject.model.workqueue.WorkRequest;
import edu.neu.csye6200.oodfinalproject.ui.StringConstants;
import edu.neu.csye6200.oodfinalproject.ui.ViewFXMLs;
import edu.neu.csye6200.oodfinalproject.ui.model.Context;
import edu.neu.csye6200.oodfinalproject.util.Utils;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.table.TableFilter;

import java.io.IOException;
import java.util.stream.Collectors;

public class WorkArea extends AnchorPane {
    private Context app;
    private Dashboard parentController;

    @FXML
    private TableView<WorkRequest> tblAllRequests;

    @FXML
    private TableView<WorkRequest> tblMyWorkQueue;

    @FXML
    private TableColumn<WorkRequest, String> colOriginatingNetwork;

    @FXML
    private TableColumn<WorkRequest, String> colOriginatingEnterprise;

    @FXML
    private TableColumn<WorkRequest, String> colPatientName;

    @FXML
    private TableColumn<WorkRequest, String> colSender;

    @FXML
    private TableColumn<WorkRequest, String> colReceiver;

    @FXML
    private TableColumn<WorkRequest, String> colStatus;

    @FXML
    private TableColumn<WorkRequest, String> colSentOn;

    @FXML
    private TableColumn<WorkRequest, String> colCompletedOn;

    @FXML
    private TableColumn<WorkRequest, String> colRequestType;


    @FXML
    private TableColumn<WorkRequest, String> colMyQueueOriginatingNetwork;

    @FXML
    private TableColumn<WorkRequest, String> colMyQueueOriginatingEnterprise;

    @FXML
    private TableColumn<WorkRequest, String> colMyQueuePatientName;

    @FXML
    private TableColumn<WorkRequest, String> colMyQueueSender;

    @FXML
    private TableColumn<WorkRequest, String> colMyQueueSentOn;

    @FXML
    private TableColumn<WorkRequest, String> colMyQueueRequestReceiver;

    @FXML
    private TableColumn<WorkRequest, String> colMyQueueRequestType;

    @FXML
    private TableColumn<WorkRequest, String> colMyQueueStatus;

    @FXML
    private Button btnAcceptRequest;

    @FXML
    private Button btnRejectRequest;

    @FXML
    private Button btnProcess;

    private ObservableList<WorkRequest> allRequestsObservableList;

    private ObservableList<WorkRequest> myRequestsObservableList;

    WorkArea(Dashboard dashboard) {
        this.parentController = dashboard;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ViewFXMLs.DOCTOR_VIEWS.WORK_AREA.getValue()));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    private void initialize() {
        app = Context.getInstance();
        allRequestsObservableList = FXCollections.observableArrayList(app.getLoggedInUserAccount().getEmployee().getOrganization().getWorkQueue().getAllWorkRequests().stream().filter(w -> w.getSender() != null).collect(Collectors.toList()));
        myRequestsObservableList = FXCollections.observableArrayList(app.getLoggedInUserAccount().getWorkQueue().getAllWorkRequests().stream().filter(w -> w.getSender() != null).collect(Collectors.toList()));
        tblAllRequests.setItems(allRequestsObservableList);
        tblMyWorkQueue.setItems(myRequestsObservableList);
        mapTableColumns();
        TableFilter.forTableView(tblAllRequests).apply();
        TableFilter.forTableView(tblMyWorkQueue).apply();
        tblAllRequests.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends WorkRequest> observableValue, WorkRequest oldSelection, WorkRequest newSelection) {
                //toUpdate=null;
                boolean disable = true;
                if (newSelection != null) {
                    disable = false;
                }
                btnAcceptRequest.setDisable(disable);
                btnRejectRequest.setDisable(disable);
            }
        });

        tblMyWorkQueue.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends WorkRequest> observableValue, WorkRequest oldSelection, WorkRequest newSelection) {
                //toUpdate=null;
                boolean disable = true;
                if (newSelection != null) {
                    disable = false;
                }
                btnProcess.setDisable(disable);
            }
        });


    }


    public void mapTableColumns() {
        colOriginatingNetwork.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSender().getEmployee().getEnterprise().getParentNetwork().getName()));
        colOriginatingEnterprise.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSender().getEmployee().getEnterprise().getName()));
        colPatientName.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getPatient().getName()));
        colSender.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSender().getEmployee().getName()));
        colReceiver.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getReceiver() != null ? cellData.getValue().getReceiver().getEmployee().getName() : null));
        colStatus.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getStatus().getValue()));
        colSentOn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Utils.formatDateTime(cellData.getValue().getRequestDate())));
        colCompletedOn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getResolveDate() != null ? Utils.formatDateTime(cellData.getValue().getResolveDate()) : null));
        colRequestType.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getType().getValue()));


        colMyQueueOriginatingNetwork.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSender().getEmployee().getEnterprise().getParentNetwork().getName()));
        colMyQueueOriginatingEnterprise.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSender().getEmployee().getEnterprise().getName()));
        colMyQueuePatientName.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getPatient().getName()));
        colMyQueueSender.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSender().getEmployee().getName()));
        colMyQueueSentOn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Utils.formatDateTime(cellData.getValue().getRequestDate())));
        colMyQueueRequestReceiver.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getReceiver()!=null? cellData.getValue().getReceiver().getEmployee().getName():null));
        colMyQueueRequestType.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getType().getValue()));
        colMyQueueStatus.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getStatus().getValue()));
    }

    @FXML
    private void acceptWorkRequest() {
        WorkRequest workRequest = tblAllRequests.getSelectionModel().getSelectedItem();
        if (!workRequest.getStatus().equals(WorkRequest.WorkRequestStatus.PENDING)) {
            app.buildAlert(Alert.AlertType.WARNING, StringConstants.ERROR, "The selected work request is not pending and therefore cannot be accepted")
                    .show();
            return;
        }
        int index = allRequestsObservableList.indexOf(workRequest);
        workRequest.setStatus(WorkRequest.WorkRequestStatus.ASSIGNED);
        workRequest.setReceiver(app.getLoggedInUserAccount());
        app.getLoggedInUserAccount().getWorkQueue().addWorkRequest(workRequest);
        Utils.sendSms("Your request has been accepted by " + app.getLoggedInUserAccount().getEmployee().getName(), workRequest.getSender().getEmployee().getPhoneNumber());
        Utils.sendEmail(workRequest.getSender().getEmployee().getEmail(), app.getLoggedInUserAccount().getEmployee().getEmail(), "[" + StringConstants.APP_NAME + "] Work Request Accepted", "Dear " + workRequest.getSender().getEmployee().getName() + "\n\nYour request has been accepted by " + app.getLoggedInUserAccount().getEmployee().getName());
        allRequestsObservableList.set(index, workRequest);
        myRequestsObservableList.add(workRequest);
        app.buildAlert(Alert.AlertType.INFORMATION, StringConstants.SUCCESS, "Work Requested accepted and added to your queue").show();
        app.storeSystem();
    }

    @FXML
    private void rejectWorkRequest() {
        WorkRequest workRequest = tblAllRequests.getSelectionModel().getSelectedItem();

        if (!workRequest.getStatus().equals(WorkRequest.WorkRequestStatus.PENDING)) {
            app.buildAlert(Alert.AlertType.WARNING, StringConstants.ERROR, "The selected work request is not pending and therefore cannot be rejected")
                    .show();
            return;
        }
        int index = allRequestsObservableList.indexOf(workRequest);
        workRequest.setStatus(WorkRequest.WorkRequestStatus.REJECTED);
        Utils.sendSms("Your request has been rejected by " + app.getLoggedInUserAccount().getEmployee().getName(), workRequest.getSender().getEmployee().getPhoneNumber());
        Utils.sendEmail(workRequest.getSender().getEmployee().getEmail(), null, "[" + StringConstants.APP_NAME + "] Work Request Rejected", "Dear " + workRequest.getSender().getEmployee().getName() + ",\n\nYour request has been rejected by " + app.getLoggedInUserAccount().getEmployee().getName());
        allRequestsObservableList.set(index, workRequest);
        app.buildAlert(Alert.AlertType.INFORMATION, StringConstants.SUCCESS, "Work Requested Rejected").show();
        app.storeSystem();
    }


    @FXML
    private void processRequest() {
        if(!tblMyWorkQueue.getSelectionModel().getSelectedItem().getReceiver().equals(app.getLoggedInUserAccount())){
            app.buildAlert(Alert.AlertType.WARNING, StringConstants.ERROR, "You cannot process this request as you are not the receiver of the request").show();
        }
        /*if(!tblMyWorkQueue.getSelectionModel().getSelectedItem().getStatus().getValue().equals(WorkRequest.WorkRequestStatus.ASSIGNED.getValue())){
            app.buildAlert(Alert.AlertType.WARNING, StringConstants.ERROR, "You cannot process this request as it is not pending for processing").show();
        }*/
        WorkRequest workRequest = tblMyWorkQueue.getSelectionModel().getSelectedItem();
        if (workRequest instanceof DoctorOpinionRequest) {
            parentController.openDoctorsOpinionRequestForProcessing((DoctorOpinionRequest) workRequest);
        }

        if (workRequest instanceof LabResultWorkRequest) {
            parentController.openDoctorsOpinionRequestForProcessing(((LabResultWorkRequest) workRequest).getLabTestWorkRequest().getDoctorOpinionRequest());
        }
    }

}