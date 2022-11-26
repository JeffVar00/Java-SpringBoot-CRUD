import { NavLink } from "react-router-dom";

export const NavButton = ({ redirectTo = "/", inputName = "null" }) => {
  let sleep = "nav-link text-dark";
  let active = "nav-link text-dark border-bottom border-dark border-2";

  return (
    <div>
      <NavLink
        className={({ isActive }) => (isActive ? active : sleep)}
        to={redirectTo}
      >
        {inputName}
      </NavLink>
    </div>
  );
};
