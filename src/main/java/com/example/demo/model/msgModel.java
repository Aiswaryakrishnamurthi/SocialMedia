/*package com.example.demo.model;



public class msgModel {
    private String from;
    private String to;
    private String content;

    // Getters and setters
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
@Entity
public class msgModel {
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "sender_id", nullable = false)
	    private User sender;

	    @ManyToOne
	    @JoinColumn(name = "receiver_id", nullable = false)
	    private User receiver;

	    @Column(nullable = false)
	    private String content;

	    @Column(nullable = false)
	    private LocalDateTime timestamp;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public User getSender() {
			return sender;
		}

		public void setSender(User sender) {
			this.sender = sender;
		}

		public User getReceiver() {
			return receiver;
		}

		public void setReceiver(User receiver) {
			this.receiver = receiver;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public LocalDateTime getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}

	   
	}
*/

