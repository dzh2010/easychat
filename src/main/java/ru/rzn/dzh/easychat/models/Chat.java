package ru.rzn.dzh.easychat.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    
    @OneToMany(mappedBy="chat")
    @JsonIgnore
    private List<Message> messages;

    public Chat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", messages=" + messages +
                '}';
    }
}
