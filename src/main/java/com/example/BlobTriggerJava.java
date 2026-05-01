package com.example;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Azure Blob trigger.
 */
public class BlobTriggerJava {
    /**
     * This function will be invoked when a new or updated blob is detected at the specified path. The blob contents are provided as input to this function.
     */
    @FunctionName("BlobTriggerJava")
    public void run(
        @BlobTrigger(name = "content", path = "blobexamplehar/{name}", dataType = "binary",connection = "AzureWebJobsStorage") byte[] content,
        @BindingName("name") String fileName,
        final ExecutionContext context
    ) {
        context.getLogger().info("Blob is triggered now -deployed by pipeline......: " + fileName + "\n  Size: " + content.length + " Bytes");
    }
}
