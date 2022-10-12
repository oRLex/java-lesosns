package app.controller;

public interface View {
  // entity field
  interface FieldSet0 {}
  interface FieldSet1 {}
  interface FieldSet2 {}

  // controller
  interface Admin extends FieldSet0, FieldSet1 {}
  interface Guest extends FieldSet0, FieldSet2 {}
  interface Manager extends FieldSet0, FieldSet1, FieldSet2 {}
  interface Director extends Manager, Admin {}
}
