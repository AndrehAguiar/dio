import { CourseService } from './course.service';
import { Component, OnInit } from "@angular/core";
import { Course } from "./course";
import { ASTWithSource } from '@angular/compiler';

@Component({
  templateUrl: './course-list.component.html',
  styleUrls: ['./courses-list.component.css']
})
export class CourseListComponent implements OnInit {

  filterCourses: Course[] = [];

  _courses: Course[] = [];

  _filterBy!: string;

  constructor(private courseService: CourseService) { }

  ngOnInit(): void {
    this._courses = this.courseService.retrieveAll();
    this.filterCourses = this._courses;
  }

  set filter(value: string) {
    this._filterBy = value;
    this.filterCourses = this._courses.filter(
      (course: Course) => course.name.toLocaleLowerCase()
        .indexOf(this._filterBy.toLocaleLowerCase()) > 1
    );
  }
  get filter() {
    return this._filterBy;
  }
}
