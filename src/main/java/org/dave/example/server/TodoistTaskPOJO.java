package org.dave.example.server;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class TodoistTaskPOJO implements TaskTransmissionRepresentation {

  @SerializedName("due_date")
  @Expose
  private String dueDate;
  @SerializedName("user_id")
  @Expose
  private Integer userId;
  @Expose
  private Integer collapsed;
  @SerializedName("in_history")
  @Expose
  private Integer inHistory;
  @Expose
  private Integer priority;
  @SerializedName("item_order")
  @Expose
  private Integer itemOrder;
  @Expose
  private String content;
  @Expose
  private Integer indent;
  @SerializedName("project_id")
  @Expose
  private Integer projectId;
  @Expose
  private Integer id;
  @Expose
  private Integer checked;
  @SerializedName("date_string")
  @Expose
  private String dateString;

  /**
   * @return The dueDate
   */
  public String getDueDate() {
    return dueDate;
  }

  /**
   * @param dueDate The due_date
   */
  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }

  /**
   * @return The userId
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * @param userId The user_id
   */
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  /**
   * @return The collapsed
   */
  public Integer getCollapsed() {
    return collapsed;
  }

  /**
   * @param collapsed The collapsed
   */
  public void setCollapsed(Integer collapsed) {
    this.collapsed = collapsed;
  }

  /**
   * @return The inHistory
   */
  public Integer getInHistory() {
    return inHistory;
  }

  /**
   * @param inHistory The in_history
   */
  public void setInHistory(Integer inHistory) {
    this.inHistory = inHistory;
  }

  /**
   * @return The priority
   */
  public Integer getPriority() {
    return priority;
  }

  /**
   * @param priority The priority
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  /**
   * @return The itemOrder
   */
  public Integer getItemOrder() {
    return itemOrder;
  }

  /**
   * @param itemOrder The item_order
   */
  public void setItemOrder(Integer itemOrder) {
    this.itemOrder = itemOrder;
  }

  /**
   * @return The content
   */
  public String getContent() {
    return content;
  }

  /**
   * @param content The content
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * @return The indent
   */
  public Integer getIndent() {
    return indent;
  }

  /**
   * @param indent The indent
   */
  public void setIndent(Integer indent) {
    this.indent = indent;
  }

  /**
   * @return The projectId
   */
  public Integer getProjectId() {
    return projectId;
  }

  /**
   * @param projectId The project_id
   */
  public void setProjectId(Integer projectId) {
    this.projectId = projectId;
  }

  /**
   * @return The id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id The id
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return The checked
   */
  public Integer getChecked() {
    return checked;
  }

  /**
   * @param checked The checked
   */
  public void setChecked(Integer checked) {
    this.checked = checked;
  }

  /**
   * @return The dateString
   */
  public String getDateString() {
    return dateString;
  }

  /**
   * @param dateString The date_string
   */
  public void setDateString(String dateString) {
    this.dateString = dateString;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(dueDate).append(userId).append(collapsed).append(inHistory).append(priority).append(itemOrder).append(content).append(indent).append(projectId).append(id).append(checked).append(dateString).toHashCode();
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof TodoistTaskPOJO) == false) {
      return false;
    }
    TodoistTaskPOJO rhs = ((TodoistTaskPOJO) other);
    return new EqualsBuilder().append(dueDate, rhs.dueDate).append(userId, rhs.userId).append(collapsed, rhs.collapsed).append(inHistory, rhs.inHistory).append(priority, rhs.priority).append(itemOrder, rhs.itemOrder).append(content, rhs.content).append(indent, rhs.indent).append(projectId, rhs.projectId).append(id, rhs.id).append(checked, rhs.checked).append(dateString, rhs.dateString).isEquals();
  }

  @Override
  public String getName() {
    return content;
  }
}
