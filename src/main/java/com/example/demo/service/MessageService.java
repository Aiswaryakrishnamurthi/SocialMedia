/*package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.msgModel;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.UserRepository;

@Service
public class MessageService {

	@Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    public msgModel sendMessage(String senderUsername, String receiverUsername, String content) {
        User sender = userRepository.findByUsername(senderUsername);
        User receiver = userRepository.findByUsername(receiverUsername);

        if (sender == null || receiver == null) {
            throw new IllegalArgumentException("Sender or Receiver not found");
        }

        msgModel message = new msgModel();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent(content);
        message.setTimestamp(LocalDateTime.now());

        return messageRepository.save(message);
    }

    public List<msgModel> getMessages(String username) {
        User user = userRepository.findByUsername(username);
        return messageRepository.findByReceiver(user);
    }

    public List<msgModel> getConversation(String senderUsername, String receiverUsername) {
        User sender = userRepository.findByUsername(senderUsername);
        User receiver = userRepository.findByUsername(receiverUsername);
        return messageRepository.findBySenderAndReceiver(sender, receiver);
    }
}*/
