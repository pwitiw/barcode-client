package com.frontwit.barcode.restclient.common;

public class Messages {

    private Messages() {
    }

    public static final String REGISTERING_HOOK_ERROR = "There was a problem registering the native hook.";
    public static final String SERVER_UNREACHABLE = "Server is not reachable.";
    public static final String TASK_EXECUTED_SUCCESSFULLY = "Task executed. %d barcodes sent.";
    public static final String TASK_EXECUTED_NOT_SUCCESSFULLY = "Task executed, barcodes could not be sent.";
}
