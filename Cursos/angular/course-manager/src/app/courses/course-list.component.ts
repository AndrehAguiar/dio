import { Component, OnInit } from "@angular/core";
import { Course } from "./course";

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls:['./courses-list.component.css']
})
export class CourseListComponent implements OnInit {

  courses: Course[] = [];

  ngOnInit(): void {
    this.courses = [
      {
        id: 1,
        name: 'Angular: Forms',
        imageUrl: 'assets/images/forms.png',
        price: 99.90,
        code: 'XPS-9876',
        duration: 120,
        rating: 3.5,
        releaseDate: 'December, 2, 2019'
      },
      {
        id: 2,
        name: 'Angular: HTTP',
        imageUrl: 'assets/images/http.png',
        price: 49.90,
        code: 'XPS-1234',
        duration: 80,
        rating: 4.2,
        releaseDate: 'November, 5, 2020'
      }
    ]
  }
}
