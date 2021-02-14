package com.customshop.back.model.entity;

import java.util.List;

public interface Detailed<T extends BasicDetails> extends Unique {

    //TODO: replace with Set

    List<T> getDetails();

    void setDetails(List<BasicDetails> details);
}
