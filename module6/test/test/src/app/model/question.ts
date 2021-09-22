import {QuestionType} from './question-type';
import {User} from './user';

export interface Question {
  questionId?;
  questionTitle?;
  questionContent?;
  questionAnswer?;
  dateQuestion?;
  questionType?: QuestionType;
  userCreated?: User;
  userFeedBack?: User;
  status?;
  flag?;
}
