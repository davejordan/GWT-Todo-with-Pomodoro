package org.dave.example.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.*;
import org.dave.example.shared.Task;
import org.dave.example.shared.TaskList;

/**
 * Created by David on 27/02/2015.
 */
public class TaskSelectView extends Composite implements TaskSelectPresenter.Display {

  @UiTemplate("TaskSelectView.ui.xml")
  interface UIBinderTaskSelectView extends UiBinder<Widget, TaskSelectView> {
  }

  private static UIBinderTaskSelectView uiBinder = GWT.create(UIBinderTaskSelectView.class);

  @UiField
  Label label;
  @UiField
  ListBox list;
  @UiField
  Button button;
  @UiField
  Label errorLabel;

  TaskSelectPresenter presenter;

  public TaskSelectView() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @UiHandler("button")
  public void doClick(ClickEvent event) {
    presenter.refreshFullTaskList();
  }

  @Override
  public void clear() {
    label.setText("");
  }

  @Override
  public void showError(String name) {
    errorLabel.setText(name);
  }

  @Override
  public void setList(TaskList taskList) {
    list.clear();
    for (Task t : taskList) {
      list.addItem(t.getName());
    }
  }

  @Override
  public Widget asWidget() {
    return this;
  }

  @Override
  public void setPresenter(TaskSelectPresenter presenter) {
    this.presenter = presenter;
  }
}
