import { expect, test, describe } from "vitest";
import { testFunction } from "./black-box.js";

describe("Non-simplified", () => {
  test("A and B and C and D is TRUE", () => {
    expect(testFunction(true, true, true, true)).toBeTruthy();
  });

  test("A and !B and C and D is TRUE", () => {
    expect(testFunction(true, false, true, true)).toBeTruthy();
  });

  test("!A and !B and C and D is FALSE", () => {
    expect(testFunction(false, false, true, true)).toBeFalsy();
  });

  test("!A and B and C and D is FALSE", () => {
    expect(testFunction(false, true, true, true)).toBeFalsy();
  });

  test("A and B and C and !D is TRUE", () => {
    expect(testFunction(true, true, true, false)).toBeTruthy();
  });

  test("A and !B and C and !D is TRUE", () => {
    expect(testFunction(true, false, true, false)).toBeTruthy();
  });

  test("!A and !B and C and !D is FALSE", () => {
    expect(testFunction(false, false, true, false)).toBeFalsy();
  });

  test("!A and B and C and !D is TRUE", () => {
    expect(testFunction(false, true, true, false)).toBeTruthy();
  });

  test("A and B and !C and !D is FALSE", () => {
    expect(testFunction(true, true, false, false)).toBeFalsy();
  });

  test("A and !B and !C and !D is FALSE", () => {
    expect(testFunction(true, false, false, false)).toBeFalsy();
  });

  test("!A and !B and !C and !D is FALSE", () => {
    expect(testFunction(false, false, false, false)).toBeFalsy();
  });

  test("!A and B and !C and !D is TRUE", () => {
    expect(testFunction(false, true, false, false)).toBeTruthy();
  });

  test("A and B and !C and D is FALSE", () => {
    expect(testFunction(true, true, false, true)).toBeFalsy();
  });

  test("A and !B and !C and D is FALSE", () => {
    expect(testFunction(true, false, false, true)).toBeFalsy();
  });

  test("!A and !B and !C and D is FALSE", () => {
    expect(testFunction(false, false, false, true)).toBeFalsy();
  });

  test("!A and B and !C and D is FALSE", () => {
    expect(testFunction(false, true, false, true)).toBeFalsy();
  });
});

describe("K-map simplified", () => {
  test("A and C is TRUE", () => {
    for (let i = 0; i < 100; i++) {
      expect(
        testFunction(true, Math.random() < 0.5, true, Math.random() < 0.5),
      ).toBeTruthy();
    }
  });

  test("!A and B and !D is TRUE", () => {
    for (let i = 0; i < 100; i++) {
      expect(
        testFunction(false, true, Math.random() < 0.5, false),
      ).toBeTruthy();
    }
  });

  test("Everything else is FALSE", () => {
    for (let i = 0; i < 500; i++) {
      const a = Math.random() < 0.5;
      const b = Math.random() < 0.5;
      const c = Math.random() < 0.5;
      const d = Math.random() < 0.5;

      if (!((a && c) || (!a && b && !d))) {
        expect(testFunction(a, b, c, d)).toBeFalsy();
      }
    }
  });
});
