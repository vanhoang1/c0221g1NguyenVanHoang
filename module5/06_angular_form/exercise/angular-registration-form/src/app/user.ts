export class User {
  public constructor(init?: Partial<User>) {
  Object.assign(this, init);
  }
  email: string;
  password: string;
  country: string;
  age: number;
  gender: string;
  phone: string;
}
