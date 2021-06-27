package funsets

class FunSetSuite extends munit.FunSuite:

  import FunSets.*

  /**
   * CONTAINS
   */
  test("Contains Pass: Implemented") {
    assert(contains(x => true, 100))
  }
  
  test("Contains Pass: 4 in S: x > 3") {
    assert(contains(x => x > 3, 4))
  }
  
  test("Contains Fail: 4 not in S: x < -3") {
    assert(!contains(x => x < -3, 4))
  }
  

  /**
   * SINGLETON SET
   */
  trait TestSets:
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  
  test("Singleton Set Pass: 1 in {1}") {
    new TestSets:
      assert(contains(s1, 1))
  }

  test("Singleton Set Fail: 2 not in {1}") {
    new TestSets:
      assert(!contains(s1, 2))
  }

  /**
   * UNION
   */
  test("Union Pass/Fail: s1 ∪ s2") {
    new TestSets:
      val s = union(s1, s2)
      assert(contains(s, 1))
      assert(contains(s, 2))
      assert(!contains(s, 3))
  }

  /**
   * INTERSECT
   */
  test("Instersect Fail: s1 ∩ s2") {
    new TestSets:
      val s = intersect(s1, s2)
      assert(!contains(s, 1))
  }

  test("Instersect Pass: (s1 ∪ s2) ∩ s2") {
    new TestSets:
      val u = union(s1, s2)
      val s = intersect(u, s2)
      assert(contains(s, 2))
  }

  /**
   * DIFF
   */
  test("Diff Pass: s1 - s2") {
    new TestSets:
      val s = diff(s1, s2)
      assert(contains(s, 1))
  }

  test("Diff Fail: s1 - s1") {
    new TestSets:
      val s = diff(s1, s1)
      assert(!contains(s, 1))
  }

  test("Diff Fail: (s1 ∪ s2) - s2") {
    new TestSets:
      val u = union(s1, s2)
      val s = diff(u, s2)
      assert(contains(s, 1))
  }

  /**
   * FILTER
   */
  test("Filter Pass: s3 && x > 2") {
    new TestSets:
      val s = filter(s3, x => x > 2)
      assert(contains(s3, 3))
  }

  test("Filter Fail: s3 && x > 3") {
    new TestSets:
      val s = filter(s3, x => x > 3)
      assert(!contains(s, 3))
  }

  /**
   * FOR ALL
   */
  test("For All Pass: for all x in (s1 ∪ s2 ∪ s3), x > 0") {
    new TestSets:
      val s = union(union(s1, s2), s3)
      assert(forall(s, x => x > 0))
  }

  test("For All Fail: for all x in (s1 ∪ s2 ∪ s3), x > 1") {
    new TestSets:
      val s = union(union(s1, s2), s3)
      assert(!forall(s, x => x > 1))
  }

  /**
   * EXISTS
   */
  test("Exists Pass: for all x in (s1 ∪ s2 ∪ s3), x > 2") {
    new TestSets:
      val s = union(union(s1, s2), s3)
      assert(exists(s, x => x > 2))
  }

  test("Exists Fail: for all x in (s1 ∪ s2 ∪ s3), x > 3") {
    new TestSets:
      val s = union(union(s1, s2), s3)
      assert(!exists(s, x => x > 3))
  }

  /**
   * MAP
   */
  test("Map Pass: for all x in (s1 ∪ s2 ∪ s3), x = x * 2") {
    new TestSets:
      val u = union(union(s1, s2), s3)
      val s = map(u, x => x * 2)
      assert(contains(s, 2))
      assert(contains(s, 4))
      assert(contains(s, 6))
  }

  test("Map Fail: for all x in (s1 ∪ s2 ∪ s3), x = x * 2") {
    new TestSets:
      val u = union(union(s1, s2), s3)
      val s = map(u, x => x * 2)
      assert(!contains(s, 1))
      assert(!contains(s, 3))
  }


  import scala.concurrent.duration.*
  override val munitTimeout = 10.seconds
