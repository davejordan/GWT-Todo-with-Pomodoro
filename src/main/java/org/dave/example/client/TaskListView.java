package org.dave.example.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import org.dave.example.shared.Task;

import java.util.Set;

/**
 * Created by David on 01/03/2015.
 */
public class TaskListView extends Composite implements TaskListPresenter.Display {

  private static UIBinderTaskListView uiBinder = GWT.create(UIBinderTaskListView.class);

  private TaskListPresenter presenter;

  public TaskListView() {
    listBox.setMultipleSelect(true);
    initWidget(uiBinder.createAndBindUi(this));
  }

  @UiTemplate("TaskListView.ui.xml")
  interface UIBinderTaskListView extends UiBinder<Widget, TaskListView> {
  }


  @UiField
  private ListBox listBox;

  @Override
  public void addTaskSet(Set<Task> taskSet) {
    for (Task t: taskSet)
      listBox.addItem(t.getName());
  }


  @Override
  public Widget asWidget() {
    return this;
  }

  @Override
  public void setPresenter(TaskListPresenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void clear() {

  }
}
