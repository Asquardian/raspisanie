# РАСПИСАНИЕ ДЛЯ УЧЕБЫ

===========================================

Расписание для Android

# База данных SQL

TIME : TEXT для времени. Генерируется по номеру пары в расписании

SUBJECT : TEXT имя предмета

DAY : INTEGER день недели 

TEACHER : TEXT имя преподавателя

TYPE : INTEGER для лекций и практик

PLACE : TEXT место

# КЛАССЫ 



## Day 

Нужен для работы с днями. Используется массив для распределения по времени



## Database

Нужен для работы с базой данных

## Lesson

### Метод MakeTime

Нужен для перевода номера пары во время


 
## LessonAdapter

Адаптер для класса Lesson

Создает из класса Lesson кнопку

Наследуется от ArrayAdapter для дальнейшего создания ListView



## PagerApadterDay

Создает страницу дня с помощью ShowDayFragment

Наследуется от FragmentStateAdapter



## ShowDayFragment

Создает день на основе данных

Наследуется от Fragment



## groupList

Нужен для создания групп

Функицонал в разработке












