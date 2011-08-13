package com.arantius.tivocommander.rpc.request;

import java.util.HashMap;

import org.codehaus.jackson.JsonNode;

public class Subscribe extends MindRpcRequest {
  public Subscribe() {
    super("subscribe");

    mDataMap.put("bodyId", "-");
    mDataMap.put("recordingQuality", "best");
  }

  public void setCollection(String collectionId, JsonNode channel, int max,
      String which) {
    HashMap<String, Object> idSetSource = new HashMap<String, Object>();
    idSetSource.put("channel", channel);
    idSetSource.put("collectionId", collectionId);
    idSetSource.put("type", "seasonPassSource");
    mDataMap.put("idSetSource", idSetSource);
    mDataMap.put("maxRecordings", max);
    mDataMap.put("showStatus", which);
  }

  public void setKeep(String behavior, Integer duration) {
    mDataMap.put("keepBehavior", behavior);
    if ("duration".equals(behavior)) {
      mDataMap.put("keepDuration", duration);
    }
  }

  public void setOffer(String offerId, String contentId) {
    HashMap<String, String> idSetSource = new HashMap<String, String>();
    idSetSource.put("contentId", contentId);
    idSetSource.put("offerId", offerId);
    idSetSource.put("type", "singleOfferSource");
    mDataMap.put("idSetSource", idSetSource);
  }

  public void setPadding(Integer start, Integer stop) {
    if (start != null) {
      mDataMap.put("startTimePadding", start);
    }
    if (stop != null) {
      mDataMap.put("endTimePadding", stop);
    }
  }

  public void setPriority(Integer priority) {
    if (priority > 0) {
      mDataMap.put("priority", 1);
    }
    if (priority > 1) {
      mDataMap.put("ignoreConflicts", true);
    }
  }
}
