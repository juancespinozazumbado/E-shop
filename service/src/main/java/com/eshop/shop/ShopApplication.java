package com.eshop.shop;

import java.security.Guard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.Getter;
import lombok.Setter;

@SpringBootApplication
@RestController
public class ShopApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShopApplication.class, args);
	}

	public static List<Taskitem> _taskList = new ArrayList<Taskitem>();

	@GetMapping("/hellow")
	public static String hellow(@RequestParam(value = "myName", defaultValue = "World") String name) {
		return "Hellow" + " " + name;
	}

	@GetMapping("/tasks")
	static List<Taskitem> tasks() {

		// List<String> currentTasks = List.of(
		// 		"Do your homework",
		// 		"Set up the server",
		// 		"Buy a  new car");
		// var currentTasks = _taskList;

		try {
			return _taskList;
			
		} catch (Exception e) {
			System.err.println("error: "+ e.getMessage());
			return null;
		}
	

	}

	@PostMapping("/task")
	public TaskRecord addTask(@RequestBody TaskRecord record) {
	// TODO: process POST request

	 var newTask = new Taskitem(record.TaskName, record.isDone);
	 _taskList.add(newTask);


	 return record;
	}

	// @AllArgsConstructor
	// @NoArgsConstructor
	public record TaskRecord (
		 String TaskName,
		 boolean isDone

	){}


	@Getter @Setter 
	@AllArgsConstructor
	class Taskitem {

		private String TaskName;
		private String TaskId;
		private boolean isDone;

		public Taskitem(String taskName, boolean isCompleted){

			this.isDone = isCompleted;
			this.TaskName = taskName; 
			this.TaskId = "t_"+ (int)(Math.random() * ((100 - 1) + 1));
		}
	}

}
