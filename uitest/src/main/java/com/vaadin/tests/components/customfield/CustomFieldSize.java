/*
 * Copyright 2000-2016 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.tests.components.customfield;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.v7.ui.LegacyTextField;

/**
 *
 * @since
 * @author Vaadin Ltd
 */
public class CustomFieldSize extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        layout.setWidth("50px");

        layout.addComponent(new TextField());

        layout.addComponent(new TestCustomField());
    }

    @Override
    protected String getTestDescription() {
        return "Any part of a TextField wrapped in a CustomField should not be cut off even when the dimensions of the TextField exceed those of the CustomField";
    }

    @Override
    protected Integer getTicketNumber() {
        return 12482;
    }

    private static class TestCustomField extends CustomField<String> {

        private TextField field = new TextField();

        @Override
        protected Component initContent() {
            return field;
        }

        @Override
        public String getValue() {
            return field.getValue();
        }

        @Override
        protected void doSetValue(String value) {
            field.setValue(value);
        }
    }

}
