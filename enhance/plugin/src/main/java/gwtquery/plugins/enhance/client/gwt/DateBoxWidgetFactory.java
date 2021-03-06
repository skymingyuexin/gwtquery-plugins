/*
 * Copyright 2011, The gwtquery team.
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
package gwtquery.plugins.enhance.client.gwt;

import static com.google.gwt.query.client.GQuery.$;

import java.util.Date;

import com.google.gwt.dom.client.Element;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.plugins.widgets.WidgetFactory;
import com.google.gwt.query.client.plugins.widgets.WidgetsUtils;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

/**
 * Factory used to create a {@link DateBox} widget.
 * 
 * The content of the element has to be empty, a valid date or a valid date-format string.
 */
public class DateBoxWidgetFactory implements WidgetFactory<DateBox> {
  
  public DateBox create(Element e) {
    String v = null;
    if ($(e).filter("input[type='text']").size() == 1) {
      v = GQuery.$(e).val();
    } else {
      v = GQuery.$(e).text();
    }
    if (v!=null) {
      DateBox w = create(v);
      WidgetsUtils.replaceOrAppend(e, w);
      return w;
    }
    return null;
  }
  
  @SuppressWarnings("deprecation")
  private DateBox create(String v) {
    Date d = new Date();
    DateTimeFormat f = null;
    if (v != null) {
      try {
        d = new Date(v);
      } catch (Exception e) {
        try {
          f = DateTimeFormat.getFormat(v);
        } catch (Exception e2) {
        }
      }
    }
    DateBox b = new DateBox();
    b.setValue(d);
    if (f != null) {
      b.setFormat(new DefaultFormat(f));
    }
    return b;
  }
}