const Database = (() => {
  let instance = null;

  function createInstance() {
    return {
      query(sql) {
        console.log(`[DB] Executing: ${sql}`);
      }
    };
  }

  return {
    getInstance() {
      if (!instance) instance = createInstance();
      return instance;
    }
  };
})();

const db1 = Database.getInstance();
const db2 = Database.getInstance();

console.log("Same instance?", db1 === db2);
db1.query("SELECT * FROM users;");
