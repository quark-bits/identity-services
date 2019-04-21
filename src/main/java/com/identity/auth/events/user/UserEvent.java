package com.identity.auth.events.user;

import com.identity.auth.events.Event;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserEvent implements Event {
  private Long objectId;
  private int objectType;
  private String eventType;

   /* private constructor */
   private UserEvent(){}

   public static class UserEventBuilder{
       private Long id;
       private int objectType;
       private UserEventType userEventType;

       public UserEventBuilder(final Long id, final int objectType){
           this.id = id;
           this.objectType = objectType;
       }

       public UserEventBuilder setEventType(final UserEventType userEventType){
           this.userEventType = userEventType;
           return this;
       }

       public UserEvent build(){
           UserEvent userEvent = new UserEvent();
           userEvent.setObjectId(id);
           userEvent.setObjectType(objectType);
           userEvent.setEventType(userEventType.name());
           return userEvent;
       }
   }

    public enum UserEventType{
        REGISTERED,
        MODIFIED,
        LOGIN_SUCCESS,
        LOGIN_FAILURE,
        LOGOUT,
        DELETED;
    }
}
