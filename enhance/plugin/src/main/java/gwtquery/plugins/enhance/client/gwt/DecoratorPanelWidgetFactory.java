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

import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.plugins.widgets.WidgetFactory;
import com.google.gwt.query.client.plugins.widgets.WidgetsHtmlPanel;
import com.google.gwt.query.client.plugins.widgets.WidgetsUtils;
import com.google.gwt.user.client.ui.DecoratorPanel;

public class DecoratorPanelWidgetFactory implements
    WidgetFactory<DecoratorPanel> {

  public DecoratorPanelWidgetFactory() {
  }

  public DecoratorPanel create(Element e) {

    DecoratorPanel decoratorPanel = new DecoratorPanel();

    WidgetsUtils.replaceOrAppend(e, decoratorPanel);

    decoratorPanel.add(new WidgetsHtmlPanel(e));

    return decoratorPanel;
  }

}
