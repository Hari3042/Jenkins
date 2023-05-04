package com.appranix.demo.locations;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;

public enum AppFeatures implements Feature {

    @Label("Database Feature")
    DATABASE,

    @Label("File Feature")
    FILE;
}
