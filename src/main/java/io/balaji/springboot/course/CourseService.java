package io.balaji.springboot.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	/*
	private List<Topic> topics = new ArrayList<> (Arrays.asList(
			new Topic("spring","Spring","Spring Framwork"),
			new Topic("springboot","Sprong Boot","Spring Boot"),
			new Topic("java","java","Core Java"),
			new Topic("pcf","PCF","Pivotal Cloud Foundary")
			));
			*/
	
	public List<Course> getAllCourse(String topicId){
		//return topics;
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
	}
	
	
	public Optional<Course> getCourses(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id);
	}


	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}


	public void updateCourse(Course topic) {
		courseRepository.save(topic);

	}


	public void deleteCourse(String id) {
		
		//topics.removeIf(t -> t.getId().equals(id));
		courseRepository.deleteById(id);
	}
}
